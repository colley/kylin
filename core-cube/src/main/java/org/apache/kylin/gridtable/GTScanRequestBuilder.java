/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kylin.gridtable;

import java.util.List;

import org.apache.kylin.common.util.ImmutableBitSet;
import org.apache.kylin.metadata.filter.TupleFilter;

public class GTScanRequestBuilder {
    private GTInfo info;
    private List<GTScanRange> ranges;
    private TupleFilter filterPushDown;
    private ImmutableBitSet dimensions;
    private ImmutableBitSet aggrGroupBy = null;
    private ImmutableBitSet aggrMetrics = null;
    private String[] aggrMetricsFuncs = null;
    private boolean allowStorageAggregation = true;
    private double aggCacheMemThreshold = 0;
    private int storageScanRowNumThreshold = Integer.MAX_VALUE;// storage should terminate itself when $storageScanRowNumThreshold cuboid rows are scanned, and throw exception.   
    private int storagePushDownLimit = Integer.MAX_VALUE;// storage can quit working when $toragePushDownLimit aggregated rows are produced. 

    public GTScanRequestBuilder setInfo(GTInfo info) {
        this.info = info;
        return this;
    }

    public GTScanRequestBuilder setRanges(List<GTScanRange> ranges) {
        this.ranges = ranges;
        return this;
    }

    public GTScanRequestBuilder setFilterPushDown(TupleFilter filterPushDown) {
        this.filterPushDown = filterPushDown;
        return this;
    }

    public GTScanRequestBuilder setDimensions(ImmutableBitSet dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    public GTScanRequestBuilder setAggrGroupBy(ImmutableBitSet aggrGroupBy) {
        this.aggrGroupBy = aggrGroupBy;
        return this;
    }

    public GTScanRequestBuilder setAggrMetrics(ImmutableBitSet aggrMetrics) {
        this.aggrMetrics = aggrMetrics;
        return this;
    }

    public GTScanRequestBuilder setAggrMetricsFuncs(String[] aggrMetricsFuncs) {
        this.aggrMetricsFuncs = aggrMetricsFuncs;
        return this;
    }

    public GTScanRequestBuilder setAllowStorageAggregation(boolean allowStorageAggregation) {
        this.allowStorageAggregation = allowStorageAggregation;
        return this;
    }

    public GTScanRequestBuilder setAggCacheMemThreshold(double aggCacheMemThreshold) {
        this.aggCacheMemThreshold = aggCacheMemThreshold;
        return this;
    }

    public GTScanRequestBuilder setStorageScanRowNumThreshold(int storageScanRowNumThreshold) {
        this.storageScanRowNumThreshold = storageScanRowNumThreshold;
        return this;
    }

    public GTScanRequestBuilder setStoragePushDownLimit(int storagePushDownLimit) {
        this.storagePushDownLimit = storagePushDownLimit;
        return this;
    }

    public GTScanRequest createGTScanRequest() {
        return new GTScanRequest(info, ranges, dimensions, aggrGroupBy, aggrMetrics, aggrMetricsFuncs, filterPushDown, allowStorageAggregation, aggCacheMemThreshold, storageScanRowNumThreshold, storagePushDownLimit);
    }
}