List()
List(1, 4, 5, 6)

val colors = List("red", "blue")
var names: List[String] = List()
/** Cons
 * Constructs an object from a pair of values.
 * In many functional programming langueages, the ::
 * operator implements the cons operation.
 * */

"red" :: ("yellow" :: Nil)
"red" :: ("yellow" :: ("blue" ::
  Nil))

/** Nil                       The empty list
 * Nil extends List           :: is a def on List
 * a :: Nil                   Infix form
 * Nil.::(a)                  Long hand form
 * a.::(Nil) (INCORRECT)      :: is right associative */

"red" :: "yellow" :: "blue" :: Nil

/** cons
 * Appends a value to a list
 * Prepends a value to a list */
