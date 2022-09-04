package com.example.goodcodestudy.structural.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadonlyQueryExecutor implements QueryExecutor {

    private final QueryExecutor queryExecutor;
    public ReadonlyQueryExecutor(QueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }

    @Override
    public void execute(String sql) {
        if (!isSelectQuery(sql)) {
            log.info("읽기전용이므로 CUD 쿼리는 수행되지 않습니다. : " + sql);
            return;
//            throw new RuntimeException("읽기전용이므로 CUD 쿼리는 수행되지 않습니다. : " + sql);
        }

        queryExecutor.execute(sql);
    }

    private boolean isSelectQuery(String sql) {
        return sql.startsWith("select");
    }
}
