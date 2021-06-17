db.people.insert({
  sex: 'Male',
  first_name: 'Piotr',
  last_name: 'Skrzypek',
  job: 'Student',
  email: 'pitskrz@gmail.com',
  location: {
    city: 'Warsaw',
    address: { streetname: 'Kwiatowa', streetnumber: '11' }
  },
  description: "Jestem programista",
  height: 175,
  weight: 74,
  birth_date: '1999-04-15T05:44:11Z',
  nationality: 'Poland',
  credit: [
    {
      type: 'mastercard',
      number: '1234567890678456',
      currency: 'PLN',
      balance: '897'
    }
  ]
});
