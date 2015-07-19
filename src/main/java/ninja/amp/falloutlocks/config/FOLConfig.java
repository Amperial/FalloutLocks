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
package ninja.amp.falloutlocks.config;

import ninja.amp.fallout.config.Config;

/**
 * Custom configuration files used in the fallout locks plugin.
 *
 * @author Austin Payne
 */
public enum FOLConfig implements Config {
    ;

    private final String fileName;

    FOLConfig(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

}
