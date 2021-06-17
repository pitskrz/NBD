db.people.aggregate([
  {
    $project: {
      credit: 1
    }
  },
  {
    $unwind: {
      path: '$credit'
    }
  },
  {
    $group: {
      _id: '$credit.currency',
      Suma: {
        $sum: {"$toDouble": "$credit.balance"}
      }
    }
  }
]);

