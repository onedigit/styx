/*-
 * -\-\-
 * Spotify Styx Common
 * --
 * Copyright (C) 2016 - 2017 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.spotify.styx.publisher;

import com.spotify.styx.model.SequenceEvent;

/**
 * Interface for acting on internal Styx events. For example, this can be used to publish internal
 * Styx events to third-party databases. Events will be consumed on a dedicated thread pool.
 */
public interface EventConsumer {

  /**
   * Called when a state machine transition happens due to a new internal Styx event.
   *
   * @param sequenceEvent The {@link SequenceEvent} that caused the internal state machine
   *                      transition
   */
  void event(SequenceEvent sequenceEvent);

  EventConsumer NOOP = new NoopEventConsumer();
}