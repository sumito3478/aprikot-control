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

package info.sumito3478.aprikot.control

import org.scalatest
import scalatest.FunSpec

class PipeOperatorSpec extends FunSpec {
  describe("|>") {
    it("""should pass the result of the left side to the function on the right
        |  side""".stripMargin) {
      val i = -1 |> math.abs
      assert(i === 1)
    }

    it("support pipelining with multiple functions") {
      def function1(x: Int) = x + 1

      def function2(x: Int) = x * 2

      val result = 100 |> function1 |> function2

      assert(result === 202)
    }
  }

  describe("||>") {
    it("""should pass the tuple of two arguments on the left side to the
        |  function on the right side""".stripMargin) {
      val i = (2.0, 2.0) ||> math.pow
      assert(i === 4.0)
    }
  }

  describe("|||>") {
    it("""should pass the tuple of three arguments on the left side to the
        |  function on the right side""".stripMargin) {
      def max(x: Int, y: Int, z: Int): Int = math.max(x, math.max(y, z))

      val i = (3, 1, 2) |||> max
      assert(i === 3)
    }
  }
}