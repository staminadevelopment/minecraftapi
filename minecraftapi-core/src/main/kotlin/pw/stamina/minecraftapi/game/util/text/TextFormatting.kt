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

interface TextFormatting {

    interface Adapter {
        val black: TextFormatting
        val dark_blue: TextFormatting
        val dark_green: TextFormatting
        val dark_aqua: TextFormatting
        val dark_red: TextFormatting
        val dark_purple: TextFormatting
        val gold: TextFormatting
        val gray: TextFormatting
        val dark_gray: TextFormatting
        val blue: TextFormatting
        val green: TextFormatting
        val aqua: TextFormatting
        val red: TextFormatting
        val light_purple: TextFormatting
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

        val black = formattingAdapter.black
        val dark_blue = formattingAdapter.dark_blue
        val dark_green = formattingAdapter.dark_green
        val dark_aqua = formattingAdapter.dark_aqua
        val dark_red = formattingAdapter.dark_red
        val dark_purple = formattingAdapter.dark_purple
        val gold = formattingAdapter.gold
        val gray = formattingAdapter.gray
        val dark_gray = formattingAdapter.dark_gray
        val blue = formattingAdapter.blue
        val green = formattingAdapter.green
        val aqua = formattingAdapter.aqua
        val red = formattingAdapter.red
        val light_purple = formattingAdapter.light_purple
        val yellow = formattingAdapter.yellow
        val white = formattingAdapter.white
        val obfuscated = formattingAdapter.obfuscated
        val bold = formattingAdapter.bold
        val strikethrough = formattingAdapter.strikethrough
        val underline = formattingAdapter.underline
        val italic = formattingAdapter.italic
        val reset = formattingAdapter.reset
    }
}