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

package io.pivotal.strepsirrhini.chaoslemur.bosh.cpi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allomov on 1/4/17.
 */
public class CpiExecutor {

    @Value("${bosh.cpi_path}")
    private String cpiPath;

    public void deleteVm(String id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        invokeCpiCall("delete_vm", paramMap);
    }

    private String invokeCpiCall(String methodName, Map<String, Object> argumentMap) {
        Gson gson = new GsonBuilder().create();
        String argumentMapJson = gson.toJson(argumentMap);
        String[] arguments = new String[]{methodName, argumentMapJson};
        try {
            Process exec = Runtime.getRuntime().exec(cpiPath, arguments);
//            exec.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
