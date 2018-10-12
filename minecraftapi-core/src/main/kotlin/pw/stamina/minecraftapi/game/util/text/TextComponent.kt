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

@TextComponentDslMarker
interface TextComponent {

    var style: TextStyle?

    @JvmDefault
    @TextComponentDslMarker
    fun style(init: TextStyle.() -> Unit) {
        style = (style ?: newStyle()).apply(init)
    }

    // Internally belongs to the style component
    //var clickEvent: ClickEvent? todo
    //var hoverEvent: HoverEvent? todo
    var insertion: String?

    fun append(component: TextComponent)

    @JvmDefault
    operator fun TextComponent.unaryPlus() = append(this)

    val siblings: List<TextComponent>

    /**
     * Gets the raw content of this component (but not its
     * sibling components), without any formatting codes.
     */
    fun getUnformattedComponentText(): String

    /**
     * Gets the text of this component and all sibling
     * components, without any formatting codes.
     */
    fun getUnformattedText(): String

    /**
     * Gets the text of this component and all sibling
     * components, with formatting codes added for rendering.
     */
    fun getFormattedText(): String

    interface Factory {
        fun newText(text: String): TextComponent

        fun newEmptyText(): TextComponent

        fun newStyle(): TextStyle
    }

    companion object {
        private val textComponentFactory = MinecraftApi.getAdapter().textComponentFactory

        fun newText(text: String) = textComponentFactory.newText(text)

        fun newEmptyText() = textComponentFactory.newEmptyText()

        fun newStyle() = textComponentFactory.newStyle()
    }
}