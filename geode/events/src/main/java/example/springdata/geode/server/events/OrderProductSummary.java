/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.springdata.geode.server.events;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * OrderProductSummary is an object used in the examples to show a summary of all Orders on a per-product basis, on a per
 * timeframe shard (every 10s, or every 1hr)
 *
 * @author Udo Kohlmeyer
 * @author Patrick Johnson
 */
@Data
@Region("OrderProductSummary")
public class OrderProductSummary implements Serializable {

	@Id
	private Long summaryKey;

	private BigDecimal summaryAmount;

	public OrderProductSummary(Long summaryKey, BigDecimal summaryAmount) {
		this.summaryKey = summaryKey;
		this.summaryAmount = summaryAmount;
	}
}
