db.getCollection('people').aggregate([{
$project:
    {
        "nationality": "$nationality",
        "weight": "$weight",
        "height": "$height",
        "bmi": {$divide: [
		{"$toDouble": "$weight"}, 
		{$pow: [{$divide: [{"$toDouble": "$height"}, 100]},2]}
		
		]}
    }
},
{
    $group:
    {
        _id: "$nationality",
     
        "avgbmi": {$avg: "$bmi"},
        "minbmi": {$min: "$bmi"},
        "maxbmi": {$max: "$bmi"}
    }
}, {
    $sort: {_id: 1}
}]);
