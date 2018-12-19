package com.smart.dao;

import com.smart.domain.Board;
import com.smart.test.dataset.util.XlsDataSetBeanFactory;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;
import com.smart.test.dataset.excel.MultiSchemaXlsDataSetFactory;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class BoardDaoTest  extends BaseDaoTest{

    @SpringBean("boardDao")
    private BoardDao boardDao;

    /**
     * 创建一个新的论坛版块,并更新
     *
     * @param
     */
	@BeforeMethod
	public void init(){
		SessionFactory sf  = hibernateTemplate.getSessionFactory();
		Map<String, CollectionMetadata> roleMap = sf.getAllCollectionMetadata();
		for (String roleName : roleMap.keySet()) {
			sf.evictCollection(roleName);
		}
		Map<String, ClassMetadata> entityMap = sf.getAllClassMetadata();
		for (String entityName : entityMap.keySet()) {
			sf.evictEntity(entityName);
		}
		sf.evictQueries();
	}
	@Test
    public void addBoard() throws Exception {
        //通过XlsDataSetBeanFactory数据集绑定工厂创建测试实体
        List<Board> boards = XlsDataSetBeanFactory.createBeans(BoardDaoTest.class, "XiaoChun.SaveBoards.xls", "t_board", Board.class);
        for (Board board : boards) {
            boardDao.save(board);
        }
        Board board = boardDao.load(1);
        System.out.println(board.getBoardName());
    }

    /**
     * 删除一个版块
     *
     * @param
     */

    //@Test
    public void removeBoard() {
        Board board = boardDao.get(7);
        boardDao.remove(board);
    }
    

    @Test
    //@DataSet("XiaoChun.Boards.xml")
    public void getBoard() {
        Board board = boardDao.load(1);
        assertNotNull(board);
        System.out.println(board.getBoardName());
    }
}
