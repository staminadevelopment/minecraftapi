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

@DslMarker
private annotation class TextComponentDslMarker

/**
 * Creates a new text component with the specified parameters. The
 * [prefix] is always added before the [text], and the [suffix] is
 * always added after the [text]. The [init] block always runs
 * immediately after the [text]. Last the [style] block is applied
 * to the component's style. The order remains unchanged, even if
 * some parameters are not provided.
 *
 * @param text text the new component will contain
 * @param prefix prefix is added before the [text]
 * @param suffix suffix is added after the [text]
 * @param style the style initializes the style of the component
 * @param init initializer block runs on the component returned
 */
@TextComponentDslMarker
fun newText(
        text: String? = null,
        prefix: TextComponent? = null,
        suffix: TextComponent? = null,
        style: (TextStyle.() -> Unit)? = null,
        init: (TextComponent.() -> Unit)? = null
): TextComponent {
    val component: TextComponent

    if (prefix != null || suffix != null) {
        component = TextComponent.newComponent()

        prefix?.run(component::append)
        text?.run { component.append(!text) }
        init?.run(component::apply)
        suffix?.run(component::append)
    } else {
        component = text?.let { TextComponent.newText(it) } ?: TextComponent.newComponent()

        init?.run(component::apply)
    }

    style?.run(component.style::apply)

    return component
}

/**
 * Creates a new component as described in [newText] and
 * appends it to this component.
 *
 * @see [newText]
 */
@TextComponentDslMarker
fun TextComponent.addText(
        text: String? = null,
        prefix: TextComponent? = null,
        suffix: TextComponent? = null,
        style: (TextStyle.() -> Unit)? = null,
        init: (TextComponent.() -> Unit)? = null
): TextComponent = this.also {
    append(newText(text, prefix, suffix, style, init))
}

/**
 * Converts a string to a text component.
 */
operator fun String.not() = if (this.isEmpty()) TextComponent.newComponent() else newText(this)

/**
 * Combines two text components into one.
 */
operator fun TextComponent.plus(other: TextComponent) = TextComponent.newComponent().append(this).append(other)