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
  implicit class ForwardPipeOperator[A](underlined: A) {
    def |>[R](f: A => R): R = {
      f(underlined)
    }
  }

  implicit class ForwardPipeOperatorOfTuple2[A, B](underlined: (A, B)) {
    def ||>[R](f: (A, B) => R): R = {
      f(underlined._1, underlined._2)
    }
  }

  implicit class ForwardPipeOperatorOfTuple3[A, B, C](underlined: (A, B, C)) {
    def |||>[R](f: (A, B, C) => R): R = {
      f(underlined._1, underlined._2, underlined._3)
    }
  }
}