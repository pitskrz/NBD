db.people.mapReduce(
  function () {
    emit(this.sex, { weight: this.weight, height: this.height });
  },

  function (key, values) {
    let waga_suma = 0;
    let wysokosc_suma = 0;

    values.forEach(person => {
		
		var waga = parseInt(person.weight);
		var wys = parseInt(person.height);
		
      waga_suma = waga_suma+waga;
      wysokosc_suma = wysokosc_suma+wys;
    });

    return {
      Srednia_waga: waga_suma / values.length,
      Srednia_wysokosc: wysokosc_suma / values.length
    };
  },
  { out: 'srenia_waga_i_wysokosc2' }
);




