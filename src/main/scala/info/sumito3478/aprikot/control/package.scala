/* Copyright (C) 2013 sumito3478 <sumito3478@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.sumito3478.aprikot

package object control {
  /**
   * Pimp-my-library class to add |> operator.
   *
   * |> operator passes the result of the left side to the function on the right
   * side (forward pipe operator).
   *
   * Example usage:
   * {{{
   * import info.sumito3478.aprikot.control.ForwardPipeOperator
   *
   * val i = -1 |> math.abs
   * // i == 1
   *
   * def function1(x: Int) = x + 1
   *
   * def function2(x : Int) = x * 2
   *
   * val result = 100 |> function1 |> function2
   * // result == 202
   * }}}
   */
  implicit class ForwardPipeOperator[A](underlined: A) {
    def |>[R](f: A => R): R = {
      f(underlined)
    }
  }

  /**
   * Pimp-my-library class to add ||> operator.
   *
   * ||> operator passes the tuple of two arguments on the left side to the
   * function on the right side.
   *
   * Example usage:
   * {{{
   * import info.sumito3478.aprikot.control.ForwardPipeOperatorOfTuple2
   *
   * val i = (2.0, 2.0) ||> math.pow
   * // i == 4.0
   * }}}
   */
  implicit class ForwardPipeOperatorOfTuple2[A, B](underlined: (A, B)) {
    def ||>[R](f: (A, B) => R): R = {
      f(underlined._1, underlined._2)
    }
  }

  /**
   * Pimp-my-library class to add |||> operator.
   *
   * ||> operator passes the tuple of three arguments on the left side to the
   * function on the right side.
   *
   * Example usage:
   * {{{
   * import info.sumito3478.aprikot.control.ForwardPipeOperatorOfTuple3
   *
   * def max(x: Int, y: Int, z: Int): Int = math.max(x, math.max(y, z))
   * val i = (3, 1, 2) |||> max
   * // i == 3
   * }}}
   */
  implicit class ForwardPipeOperatorOfTuple3[A, B, C](underlined: (A, B, C)) {
    def |||>[R](f: (A, B, C) => R): R = {
      f(underlined._1, underlined._2, underlined._3)
    }
  }
}