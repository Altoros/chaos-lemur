/*
 * Copyright 2014-2017 the original author or authors.
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

package io.pivotal.strepsirrhini.chaoslemur.infrastructure;

import io.pivotal.strepsirrhini.chaoslemur.Member;
import io.pivotal.strepsirrhini.chaoslemur.bosh.cpi.CpiExecutor;

/**
 * Created by allomov on 1/4/17.
 */
public class BoshCpiInfrastructure extends AbstractDirectorUtilsInfrastructure {

    private CpiExecutor cpiExecutor;

    BoshCpiInfrastructure(DirectorUtils directorUtils, CpiExecutor cpiExecutor) {
        super(directorUtils);
        this.cpiExecutor = cpiExecutor;
    }

    @Override
    public void destroy(Member member) throws DestructionException {
        cpiExecutor.deleteVm(member.getId());
    }
}
