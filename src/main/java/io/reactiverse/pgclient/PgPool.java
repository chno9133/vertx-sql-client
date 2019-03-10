/*
 * Copyright (C) 2017 Julien Viet
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
 *
 */

package io.reactiverse.pgclient;

import io.reactiverse.sqlclient.SqlPool;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;
import java.util.stream.Collector;

/**
 * A pool of connection.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@VertxGen
public interface PgPool extends SqlPool {

  PgPool preparedQuery(String sql, Handler<AsyncResult<PgRowSet>> handler);

  @GenIgnore
  <R> PgPool preparedQuery(String sql, Collector<Row, ?, R> collector, Handler<AsyncResult<PgResult<R>>> handler);
  PgPool query(String sql, Handler<AsyncResult<PgRowSet>> handler);

  @GenIgnore
  <R> PgPool query(String sql, Collector<Row, ?, R> collector, Handler<AsyncResult<PgResult<R>>> handler);
  PgPool preparedQuery(String sql, Tuple arguments, Handler<AsyncResult<PgRowSet>> handler);

  @GenIgnore
  <R> PgPool preparedQuery(String sql, Tuple arguments, Collector<Row, ?, R> collector, Handler<AsyncResult<PgResult<R>>> handler);
  PgPool preparedBatch(String sql, List<Tuple> batch, Handler<AsyncResult<PgRowSet>> handler);

  @GenIgnore
  <R> PgPool preparedBatch(String sql, List<Tuple> batch, Collector<Row, ?, R> collector, Handler<AsyncResult<PgResult<R>>> handler);

}
