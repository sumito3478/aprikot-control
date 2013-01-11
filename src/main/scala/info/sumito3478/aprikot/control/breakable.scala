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

object breakable {
  class Dummy0
  implicit object dummy0 extends Dummy0
  
  trait Nil extends Any
  
  def apply[A <: AnyRef](op: (A => Nothing) => A): A = {
    op({
      a: A =>
        return a
    })
  }
  
  def apply[A <: AnyVal](op: (A => Nothing) => A)(implicit dummy0: Dummy0): A = {
    op({
      a: A =>
        return a
    })
  }
  
  def apply[A <: __](op: (=> Nothing) => Unit): Unit = {
    op({ return })
  }
}