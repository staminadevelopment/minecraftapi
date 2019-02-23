/*
 * MIT License
 *
 * Copyright (c) 2018 Stamina Development
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package pw.stamina.minecraftapi.game.util.text

interface TextStyle {

    /**
     * The parent style of this style. If this style does not override
     * a value, it will be retrieved from this parent style.
     */
    val parentStyle: TextStyle

    /**
     * Gets the effective color of this style.
     */
    var color: TextFormatting?

    /**
     * Whether or not text of this style should be in bold.
     */
    var bold: Boolean?

    /**
     * Whether or not text of this style should be italicized.
     */
    var italic: Boolean?

    /**
     * Whether or not to format text of this style using strikethrough.
     */
    var strikethrough: Boolean?

    /**
     * Whether or not text of this style should be underlined.
     */
    var underlined: Boolean?
    
    /**
     * Whether or not text of this style should be obfuscated.
     */
    var obfuscated: Boolean?
}