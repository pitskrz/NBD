db.people.mapReduce(
  function () {
    this.credit.forEach(cc => {
      emit(cc.currency, cc.balance);
    });
  },
  function (key, values) {
    const Suma = Array.sum(values);
    const srednia = Suma / values.length;

    return { Suma, srednia };
  },
  {
    query: {
      nationality: 'Poland',
      sex: 'Female'
    },
    out: 'Polka5'
  }
);
