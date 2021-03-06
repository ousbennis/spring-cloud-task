/*
 * Copyright 2016-2019 the original author or authors.
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

package org.springframework.cloud.task.util;

import org.springframework.cloud.task.repository.TaskExecution;

/**
 * Provides the basic infrastructure for evaluating if task listener performed properly.
 *
 * @author Glenn Renfro
 */
public abstract class TestListener {

	/**
	 * Default end message to use for the start message.
	 */
	public static final String START_MESSAGE = "FOO";

	/**
	 * Default end message to use for the error message.
	 */
	public static final String ERROR_MESSAGE = "BAR";

	/**
	 * Default end message to use for the end message.
	 */
	public static final String END_MESSAGE = "BAZ";

	protected boolean isTaskStartup;

	protected boolean isTaskEnd;

	protected boolean isTaskFailed;

	protected TaskExecution taskExecution;

	protected Throwable throwable;

	/**
	 * Indicates if the task listener was called during task create step.
	 * @return true if task listener was called during task creation, else false.
	 */
	public boolean isTaskStartup() {
		return this.isTaskStartup;
	}

	/**
	 * Indicates if the task listener was called during task end.
	 * @return true if the task listener was called during task end, else false.
	 */
	public boolean isTaskEnd() {
		return this.isTaskEnd;
	}

	/**
	 * Indicates if the task listener was called during task failed step.
	 * @return true if task listener was called during task failure, else false.
	 */
	public boolean isTaskFailed() {
		return this.isTaskFailed;
	}

	/**
	 * Task Execution that was updated during listener call.
	 * @return instance of TaskExecution.
	 */
	public TaskExecution getTaskExecution() {
		return this.taskExecution;
	}

	/**
	 * The throwable that was sent with the task if task failed.
	 * @return instance of Throwable.
	 */
	public Throwable getThrowable() {
		return this.throwable;
	}

}
