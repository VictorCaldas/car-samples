/*
 * Copyright (C) 2020 The Android Open Source Project
 *
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
 */

package com.google.android.libraries.car.app.samples.showcase;

import static com.google.common.truth.Truth.assertThat;

import androidx.test.core.app.ApplicationProvider;
import com.google.android.libraries.car.app.model.ListTemplate;
import com.google.android.libraries.car.app.testing.TestCarContext;
import com.google.android.libraries.car.app.testing.model.ListTemplateController;
import com.google.android.libraries.car.app.testing.model.ToggleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

/** Tests for the {@link TaskRestrictionDemoScreen}. */
@RunWith(RobolectricTestRunner.class)
public final class TaskRestrictionDemoScreenTest {
  private final TestCarContext testCarContext =
      TestCarContext.createCarContext(ApplicationProvider.getApplicationContext());

  @Test
  public void flipToggle_expectedBehaviorHappens() {
    TaskRestrictionDemoScreen screen = new TaskRestrictionDemoScreen(0, testCarContext);

    ListTemplateController controller =
        ListTemplateController.of((ListTemplate) screen.getTemplate());

    ToggleController toggle = controller.getRowByTitle("Toggle test").getToggle();

    toggle.performClick();
    assertThat(screen.isToggleChecked()).isTrue();
    assertThat(toggle.isChecked()).isTrue();
  }
}
