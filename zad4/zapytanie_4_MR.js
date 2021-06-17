db.people.mapReduce(
  function () {
    emit(this.nationality, { weight: this.weight, height: this.height });
  },
  function (key, values) {
    let sumBmi = 0;
    let maxBmi = 0;
    let minBmi = Infinity;

    values.forEach(person => {
 
      const bmi = person.weight / ((person.height / 100) * (person.height / 100));

     
      if (bmi > maxBmi)
	  {
		  maxBmi = bmi;
	  }
      if (bmi < minBmi)
	  {
		  minBmi = bmi;
	  }
	  
	   sumBmi = sumBmi+bmi;
    });

    return { SredniaBMI: sumBmi / values.length, maxBmi, minBmi };
  },
  { out: 'Oblicznie_BMI' }
);