def assertTrue(predicate: () => Boolean): Boolean = predicate()

assertTrue(() => 12 > 10)
assertTrue(() => 12 + 34 - 12 > 30)

/* results in compilation failure,
since it need a function that takes
nothing and returns Boolean
*/
// assertTrue(12 > 10)