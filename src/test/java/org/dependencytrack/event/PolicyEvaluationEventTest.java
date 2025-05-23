/*
 * This file is part of Dependency-Track.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) OWASP Foundation. All Rights Reserved.
 */
package org.dependencytrack.event;

import java.util.ArrayList;
import java.util.List;
import org.dependencytrack.model.Component;
import org.dependencytrack.model.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PolicyEvaluationEventTest {

    @Test
    void testDefaultConstructor() {
        PolicyEvaluationEvent event = new PolicyEvaluationEvent();
        Assertions.assertNull(event.getProject());
        Assertions.assertEquals(0, event.getComponents().size());
    }

    @Test
    void testComponentConstructor() {
        Component component = new Component();
        PolicyEvaluationEvent event = new PolicyEvaluationEvent(component);
        Assertions.assertEquals(1, event.getComponents().size());
    }

    @Test
    void testComponentsConstructor() {
        Component component = new Component();
        List<Component> components = new ArrayList<>();
        components.add(component);
        PolicyEvaluationEvent event = new PolicyEvaluationEvent(components);
        Assertions.assertEquals(1, event.getComponents().size());
    }

    @Test
    void testProjectCriteria() {
        Project project = new Project();
        PolicyEvaluationEvent event = new PolicyEvaluationEvent().project(project);
        Assertions.assertEquals(project, event.getProject());
        Assertions.assertEquals(0, event.getComponents().size());
    }
}
