/*
 * Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.internal.management.events;

import com.hazelcast.internal.json.JsonObject;

public final class EventMetadata {
    private final EventType type;
    private final long timestamp;

    public EventMetadata(EventType type, long timestamp) {
        this.type = type;
        this.timestamp = timestamp;
    }

    public enum EventType {
        WAN_CONSISTENCY_CHECK_STARTED(1),
        WAN_CONSISTENCY_CHECK_FINISHED(2),
        WAN_SYNC_STARTED(3),
        WAN_SYNC_FINISHED_FULL(4),
        WAN_CONSISTENCY_CHECK_IGNORED(5),
        WAN_SYNC_PROGRESS_UPDATE(6),
        WAN_SYNC_FINISHED_MERKLE(7),
        WAN_CONFIGURATION_ADDED(8),
        ADD_WAN_CONFIGURATION_IGNORED(9),
        WAN_SYNC_IGNORED(10),
        WAN_CONFIGURATION_EXTENDED(11);

        private final int code;

        EventType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.add("type", type.code);
        json.add("timestamp", timestamp);
        return json;
    }
}
