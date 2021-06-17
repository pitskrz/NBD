object Main {

  def main(args: Array[String]): Unit = {


    println("Zadanie 1")
    println(Zadanie1("Wtorek"))
    println(Zadanie1("Niedziela"))
    println(Zadanie1("dfghj"))

    def Zadanie1(zmienna_str: String): String = {


      val wolne = List("Sobota", "Niedziela")
      val praca = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")


      zmienna_str match {
        case a
          if (praca.contains(a)) => "Praca"
        case b
          if (wolne.contains(b)) => "Weekend"
        case _ => "Nie ma takiego dnia"
      }
    }


    println("Zadanie 2")
    val kon = new KontoBankowe(70)
    println(kon.stanKonta)

    println(kon.wplata(12))
    println(kon.wyplata(10))

    val kon2 = new KontoBankowe()

    println(kon2.stanKonta)





    println("Zadanie 3")

    val osoba1 = Osoba("Piotr", "Skrzypek")

    val osoba2 = Osoba("Rober", "Lewandowski")

    val osoba3 = Osoba("Kasia", "Mielczyńska")


    Zadanie3Fun(osoba1)

    Zadanie3Fun(osoba2)

    Zadanie3Fun(osoba3)

    def Zadanie3Fun(osoba_zm: Osoba) = {
      val pow = osoba_zm match {
        case Osoba("Piotr", "Skrzypek") => "Hejka Piotrek"

        case Osoba("Rober", "Lewandowski") => "Elo Robecik"

        case _ => "Witam"


      }

      println(pow)
      pow
    }



    println("Zadanie 4")

    val liczba_cal = 2

    println(Zadanie4(liczba_cal, razy_dwa))

    def Zadanie4(number: Int, fun: (Int) => Int): Int = {
      fun(fun(fun(number)))
    }

    def razy_dwa(num: Int): Int = num *2



    println("Zadanie 5")

    val o1 = new Osoba("Elon", "Musk") with Student
    println(s"Podatek studenta: ${o1.podatek}%")

    val o2 = new Osoba("Brtek", "Jakubiak") with Pracownik
    println(s"Podatek pracownika : ${o2.podatek}%")

    val o3 = new Osoba("Maja", "Miska") with Nauczyciel
    println(s"Podatek nauczyciela : ${o3.podatek}%")

    val o4 = new Osoba("Tomek", "Locki") with Student with Pracownik
    println(s"Podatek pracującego studenta: ${o4.podatek}%")

    val o5 = new Osoba("Kaja", "Majewska") with Pracownik with Student
    println(s"Podatek studiującego pracownika: ${o5.podatek}%")
  }






}
