db.people.aggregate([
  {
    $group: {
      _id: '$sex',
      cala_waga: { $sum: {"$toDouble": "$weight"} },
      cala_wysokosc: { $sum: {"$toDouble": "$height"}},
      suma: { $sum: 1 }
    }
  },
  {
    $project: {
	  cala_wysokosc: 1,
      cala_waga: 1,
      total: 1,
	  srednia_wysokosc: {
        $divide: ['$cala_wysokosc', '$suma']
      },
      srednia_waga: {
        $divide: ['$cala_waga', '$suma']
      }
      
    }
  }
]);




