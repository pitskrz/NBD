trait Pracownik extends Osoba {
  override val podatek: Int = 20
  private[this] var _pensja: Double = 0

  def pensja: Double = _pensja

  def pensja_=(value: Double): Unit = {
    _pensja = value
  }
}
