db.people.mapReduce(
  function () {
    emit(this.job, null);
	
  },
  function (key, values) {
	  
    return 1;
  },
  {
    out: 'Kazda_praca'
  }
);