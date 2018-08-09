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

package pw.stamina.minecraftapi.module

import pw.stamina.minecraftapi.MinecraftApiAdapter
import java.util.*

class MinecraftApiModuleManager private constructor(private val modules: ServiceLoader<MinecraftApiModule>) {
    private var eventConsumer: EventConsumer? = null

    init {
        this.eventConsumer = null
    }

    fun bootstrap(adapter: MinecraftApiAdapter) {
        modules.forEach { module -> module.bootstrap(adapter) }
        eventConsumer = getEventConsumerFromModules(modules)
    }

    fun <T> consumeEvent(event: T) {
        eventConsumer!!.consumeEvent(event)
    }

    companion object {

        fun loadModules(): MinecraftApiModuleManager {
            val modules = loadModuleServiceLoader()

            return MinecraftApiModuleManager(modules)
        }

        private fun loadModuleServiceLoader(): ServiceLoader<MinecraftApiModule> {
            return ServiceLoader.load(MinecraftApiModule::class.java)
        }

        private fun getEventConsumerFromModules(modules: ServiceLoader<MinecraftApiModule>): EventConsumer {
            val eventConsumers = getAllEventConsumersFromModules(modules)

            return when (eventConsumers.size) {
                0 -> EventConsumer.empty()
                1 -> eventConsumers[0]
                else -> EventConsumer.compound(eventConsumers)
            }
        }

        private fun getAllEventConsumersFromModules(modules: ServiceLoader<MinecraftApiModule>): List<EventConsumer> {
            return modules.asSequence()
                    .map { it.eventConsumer }
                    .filterNotNull()
                    .toList()
        }
    }
}
