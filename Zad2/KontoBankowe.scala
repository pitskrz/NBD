class KontoBankowe(początkowy_stan_konta: Double) {



  private var _stanKonta: Double = początkowy_stan_konta

  def stanKonta: Double = _stanKonta



  def wplata(ile_piniendzy: Double): Double = {
    _stanKonta = _stanKonta + ile_piniendzy


    _stanKonta
  }

  def wyplata(ile_piniendzy: Double): Double = {
    if (_stanKonta - ile_piniendzy < 0)
      {
        return _stanKonta
      }

    _stanKonta = _stanKonta - ile_piniendzy
    _stanKonta
  }

  def this() {
    this(0)
  }
}
