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

import pw.stamina.minecraftapi.MinecraftApi

/**
 * Formatting codes for [TextStyle].
 */
interface TextFormatting {

    interface Adapter {
        val black: TextFormatting
        val darkBlue: TextFormatting
        val darkGreen: TextFormatting
        val darkAqua: TextFormatting
        val darkRed: TextFormatting
        val darkPurple: TextFormatting
        val gold: TextFormatting
        val gray: TextFormatting
        val darkGray: TextFormatting
        val blue: TextFormatting
        val green: TextFormatting
        val aqua: TextFormatting
        val red: TextFormatting
        val lightPurple: TextFormatting
        val yellow: TextFormatting
        val white: TextFormatting
        val obfuscated: TextFormatting
        val bold: TextFormatting
        val strikethrough: TextFormatting
        val underline: TextFormatting
        val italic: TextFormatting
        val reset: TextFormatting
    }

    companion object {
        private val formattingAdapter = MinecraftApi.getAdapter().textFormattingAdapter

        val BLACK = formattingAdapter.black
        val DARK_BLUE = formattingAdapter.darkBlue
        val DARK_GREEN = formattingAdapter.darkGreen
        val DARK_AQUA = formattingAdapter.darkAqua
        val DARK_RED = formattingAdapter.darkRed
        val DARK_PURPLE = formattingAdapter.darkPurple
        val GOLD = formattingAdapter.gold
        val GRAY = formattingAdapter.gray
        val DARK_GRAY = formattingAdapter.darkGray
        val BLUE = formattingAdapter.blue
        val GREEN = formattingAdapter.green
        val AQUA = formattingAdapter.aqua
        val RED = formattingAdapter.red
        val LIGHT_PURPLE = formattingAdapter.lightPurple
        val YELLOW = formattingAdapter.yellow
        val WHITE = formattingAdapter.white
        val OBFUSCATED = formattingAdapter.obfuscated
        val BOLD = formattingAdapter.bold
        val STRIKETHROUGH = formattingAdapter.strikethrough
        val UNDERLINE = formattingAdapter.underline
        val ITALIC = formattingAdapter.italic
        val RESET = formattingAdapter.reset
    }
}