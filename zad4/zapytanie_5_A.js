db.people.aggregate([
  {
    $match: { nationality: 'Poland', sex: 'Female' }
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
      },
      Srednia: {
        $avg: {"$toDouble": "$credit.balance"}
      }
    }
  }
]);
