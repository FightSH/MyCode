package com.shen;

import com.alibaba.excel.ExcelWriter;
import com.shen.config.AbstractExport;
import com.shen.config.ExportQueue;
import com.shen.config.ExportUser;
import lombok.extern.slf4j.Slf4j;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class ExportServiceImpl extends AbstractExport {

    private ExportQueue exportQueue;


    @Override
    public void export(ExportUser sysUser) throws InterruptedException {

        //导出
        log.info("导出文件方法执行～～～～～～～～～");
//        export(response,pageSize,t,k,fileName);
        LinkedList<ExportUser> queue = exportQueue.add(sysUser);
        log.info("导出队列：" + queue);
        //休眠时间稍微设置大点，模拟导出处理时间
        Thread.sleep(20000);
        //导出成功后移除当前导出用户
        ExportUser nextSysUser = exportQueue.getNextSysUser();
        log.info("移除后获取下一个排队的用户: " + nextSysUser.getTaskName());

    }


    @Override
    public void export(HttpServletResponse response, int pageSize, Object o, Class k, String fileName) throws Exception {
        super.export(response, pageSize, o, k, fileName);
    }

    @Override
    public ExcelWriter getExcelWriter(HttpServletResponse response, String fileName) throws IOException {
        return super.getExcelWriter(response, fileName);
    }

    @Override
    public void complexFillWithTable(Object o, String fileName, HttpServletResponse response) {

    }

    @Override
    public int countExport(Object o) {
        return 0;
    }

    @Override
    public List getExportDetail(Object o) {
        return null;
    }


}
