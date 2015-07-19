/*
 * This file is part of FalloutLocks.
 *
 * Copyright (c) 2015-2015 <http://github.com/ampayne2/FalloutLocks//>
 *
 * FalloutLocks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FalloutLocks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FalloutLocks.  If not, see <http://www.gnu.org/licenses/>.
 */
package ninja.amp.falloutlocks.message;

import ninja.amp.fallout.message.Message;

/**
 * Messages sent by the fallout locks plugin.
 *
 * @author Austin Payne
 */
public enum FOLMessage implements Message {
    RELOAD("Reload", "Reloaded %s.");

    private final String path;
    private final String defaultMessage;
    private String message;

    FOLMessage(String path, String defaultMessage) {
        this.message = defaultMessage;
        this.path = path;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getDefault() {
        return defaultMessage;
    }

    @Override
    public String toString() {
        return message;
    }

}
