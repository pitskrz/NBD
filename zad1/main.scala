import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object main {
  def main(args: Array[String]) = {

    val Lista_Dni_tyg = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")


    println("Zadanie 1 a")
    Zad1A(Lista_Dni_tyg)


    println("Zadanie 1 b")
    println(Zad1B(Lista_Dni_tyg))


    println("Zadanie 1 c")
    println(Zad1C(Lista_Dni_tyg))


    println("Zadanie 2 a")
    println(Zad2A(Lista_Dni_tyg))


    println("Zadanie 2 b")
    println(Zad2B(Lista_Dni_tyg))


    println("Zadanie 3")
    println(Zad3(Lista_Dni_tyg))


    println("Zadanie 4 a")
    println(Zad4A(Lista_Dni_tyg))


    println("Zadanie 4 b")
    println(Zad4B(Lista_Dni_tyg))


    println("Zadanie 4 c")
    println(Zad4C(Lista_Dni_tyg))


    println("Zadanie 5")
    val products = Map("Mleko" -> 5, "Jogurt" -> 2, "Chleb" -> 1)
    val productsSale = products map { case (key, value) => (key, value * 1.1) }
    println(productsSale)


    println("Zadanie 6")
    Zad6("abc", 3, Lista_Dni_tyg)


    println("Zadanie 7")

    val CenaMleka = products.get("Mleko")
    println(CenaMleka)

    val CenaChleb = products.get("Chleb")
    println(CenaChleb)


    println("Zadanie 8")
    val ListaLiczb = List(-6, 7, 16, 55, 89, 87, 22, 5, 8, 1, 0)
    println(Zad8(ListaLiczb))



    println("Zadanie 9")
    println(Zad9(ListaLiczb))


    println("Zadanie 10")
    val ListaLiczb2 = List(90, -67, -3, -1, 8, 5, 99, 1, 7, 5, 4, 3, 2, 55, 77, 900)
    println(Zad10(ListaLiczb2))
  }

  def Zad1A(DniTyg: List[String]) = {
    var Wynik_str = "";
    for (i <- 0 until DniTyg.length) {
      if (Wynik_str != "")
        {
          Wynik_str =  Wynik_str+", " + DniTyg.get(i)
        }

      else
        {
          Wynik_str = Wynik_str+ DniTyg.get(i)
        }

    }
    println(Wynik_str)

  }

  def Zad1B(DniTyg: List[String]) = {
    var Wynik_str = "";
    for (i <- 0 until DniTyg.length) {
      breakable {
        if (!DniTyg.get(i).startsWith("P"))
          {
            break
          }
        if (Wynik_str != "")
          {
            Wynik_str = Wynik_str+  ", " + DniTyg.get(i)
          }

        else
          {
            Wynik_str = Wynik_str+DniTyg.get(i)
          }

      }


    }
    Wynik_str;
  }

  def Zad1C(DniTyg: List[String]) = {
    var Wynik_str = ""
    var licznik = 0;
    while (licznik < DniTyg.length) {
      if (Wynik_str != "")
        {
          Wynik_str = Wynik_str+", " + DniTyg.get(licznik)
        }

      else
        {
          Wynik_str = Wynik_str+DniTyg.get(licznik)
        }


      licznik = licznik + 1;
    }


  }

  def Zad2A(DniTyg: List[String]) = {
    def dodaj_dzien(i: Int): String = {
      if (i == DniTyg.length)
        {
          return ""
        }
      val dzien_teraz=
       if (i == DniTyg.length - 1)
        {
          DniTyg.get(i)
        } else
        {
          DniTyg.get(i) + ", "
        }

      dzien_teraz + dodaj_dzien(i + 1)
    }

    dodaj_dzien(0);
  }

  def Zad2B(DniTyg: List[String]): String = {
    def dodaj_dzien(i: Int): String = {
      if (i == -1) return ""

      val dzien_teraz = if (i == 0) DniTyg.get(i) else DniTyg.get(i) + ", "

      dzien_teraz + dodaj_dzien(i - 1)
    }

    dodaj_dzien(DniTyg.length - 1)
  }

  def Zad3(DniTyg: List[String]) = {
    @tailrec
    def dodaj_dzien(i: Int, Wynik_str: String) : String = {
      if (i == DniTyg.length) return Wynik_str

      val dzien_teraz = if (i == DniTyg.length - 1) DniTyg.get(i) else DniTyg.get(i) + ", "

      dodaj_dzien(i + 1, Wynik_str + dzien_teraz)
    }
    dodaj_dzien(0, "")
  }

  def Zad4A(DniTyg: List[String]) : String = {
    DniTyg.fold("") {(sum, curr) => {
      sum + curr + ", "
    }}.dropRight(2)
  }

  def Zad4B(DniTyg: List[String]) : String = {
    DniTyg.foldRight("") {(sum, curr) => {
      sum + ", " + curr
    }}.dropRight(2)
  }

  def Zad4C(DniTyg: List[String]) : String = {
    DniTyg.fold("") {(sum, curr) => {
      if (curr.startsWith("P"))
        sum + curr + ", "
      else sum

    }}.dropRight(2)
  }

  def Zad6(krot: (String, Int, Any)) = {
    println(krot._1)
    println(krot._2)
    println(krot._3)
  }

  def Zad8(intList: List[Int]): List[Int] = {
    def ref(licznik: Int, ListaRef: List[Int]): List[Int] = {
      if (licznik >= ListaRef.length)
        {
          return ListaRef
        };

      val (l1, l2) = ListaRef.splitAt(licznik)

      if (ListaRef.get(licznik) == 0)
        {
          ref(licznik + 1, l1 ++ l2.tail)
        }

      else {
        {
          ref(licznik + 1, ListaRef)
        }

      }
    }


    ref(0, intList)
  }

  def Zad9(intList: List[Int]): List[Int] = {
    intList map (licz => licz + 1)
  }

  def Zad10(intList: List[Int]): List[Int] = {
    val Filt = intList filter (licz => licz >= -5 && licz <= 12)

    Filt map (licz => licz.abs)
  }
}
