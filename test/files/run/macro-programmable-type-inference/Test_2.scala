object Test extends App {
  case class Foo(i: Int, s: String, b: Boolean)
  def foo[C, L](c: C)(implicit iso: Iso[C, L]): L = iso.from(c)

  {
    val equiv = foo(Foo(23, "foo", true))
    def typed[T](t: => T) {}
    typed[(Int, String, Boolean)](equiv)
    println(equiv)
  }
}