/* Copyright 2020 The FedLearn Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.jdt.fedlearn.core.entity.mixGB;

import com.jdt.fedlearn.core.entity.Message;


/**
 * @author zhangwenxi
 */
public class BoostInferQueryResBody implements Message {
    private String[] instanceId;
    private int recordId;
    // if recordId >= 0, value means left(0) or right(1)
    // otherwise, value means leaf score
    private double value;

    public BoostInferQueryResBody(String[] instanceId, int recordId, double value) {
        this.instanceId = instanceId;
        this.recordId = recordId;
        this.value = value;
    }

    public String[] getInstanceId() {
        return instanceId;
    }

    public int getRecordId() {
        return recordId;
    }

    public double getValue() {
        return value;
    }
}