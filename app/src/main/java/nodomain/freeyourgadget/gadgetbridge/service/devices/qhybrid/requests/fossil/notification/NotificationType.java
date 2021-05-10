/*  Copyright (C) 2020-2021 Arjan Schrijver

    This file is part of Gadgetbridge.

    Gadgetbridge is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Gadgetbridge is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>. */
package nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil.notification;

public enum NotificationType {
    INCOMING_CALL(1),
    TEXT(2),
    NOTIFICATION(3),
    EMAIL(4),
    CALENDAR(5),
    MISSED_CALL(6),
    DISMISS_NOTIFICATION(7);

    private int type;

    NotificationType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
