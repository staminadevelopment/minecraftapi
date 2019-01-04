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

class TextComponentBuilder {

    private var text: TextComponent? = null
    private var style: TextStyle? = null

    private val prepend = mutableListOf<TextComponent>()
    private val append = mutableListOf<TextComponent>()

    @TextComponentDslMarker
    fun text(text: String, init: (TextComponentBuilder.() -> Unit)? = null) {
        val component = TextComponent.newText(text)

        if (init != null) {
            val builder = TextComponentBuilder()
            builder.init()

            builder.applyToComponent(component)
        }

        this.text = component
    }

    @TextComponentDslMarker
    fun prepend(text: TextComponent) {
        prepend.add(text)
    }

    @TextComponentDslMarker
    fun append(text: TextComponent) {
        append.add(text)
    }

    @TextComponentDslMarker
    fun style(init: TextStyle.() -> Unit) {
        if (style == null) {
            style = TextComponent.newStyle()
        }

        style!!.init()
    }

    fun build(): TextComponent {
        val component = TextComponent.newEmptyText()

        applyToComponent(component)

        return component
    }

    private fun applyToComponent(component: TextComponent) {
        prepend.forEach(component::append)
        text?.run(component::append)
        append.forEach(component::append)

        style?.run { component.style = this }
    }
}