import com.dao.IndentItemDao;
import com.domain.*;
import com.service.*;
import config.RootConfig;
import config.WebAppInitializer;
import config.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

//声明式事务管理器只能处理INNODB类型的数据库--折腾了很久
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class, WebAppInitializer.class})
public class testAllCRUD {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IndentService indentService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IndentItemDao indentItemDao;
    @Autowired
    private IUserService userService;
    @Autowired
    private ISysLogService sysLogService;
    @Autowired
    private IPermissionService permissionService;

    @Test
    public void testPermissionCRUD(){
        Permission permission = permissionService.findById(1);
        System.out.println(permission);
    }

    @Test
    public void testSysLogCRUD(){
//        SysLog sysLog = new SysLog();
        List<SysLog> sysLogs = sysLogService.findAll();
        for (SysLog sysLog : sysLogs){
            System.out.println(sysLog);
        }
    }

    @Test
    public void testUserCRUD(){
//        User user = new User();
//        user.setId(4);
//        user.setUsername(userService.findById(4).getUsername());
//        user.setPassword(userService.findById(4).getPassword());
//        user.setStatus(1);
//        userService.updateUser(user);
    }

    @Test
    public void testCustomerCRUD(){
//        根据ID
//        Indent indent = indentDao.findIndentById(684536001);
//        System.out.println(indent);
//        查全部
        List<Customer> customers = customerService.findAll();
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }

    @Test
    public void testIndentItemCRUD(){
        IndentItem indentItem = indentItemDao.findIndentItemById(1);
        System.out.println(indentItem);
//        indentItemService.findAll();
    }

    @Test
    public void testIndentCRUD(){
//        根据ID
        Indent indent = indentService.findIndentById(536001);
        System.out.println(indent);
//        查全部
//        List<Indent> indents = indentService.findAll();
//        for (Indent indent : indents){
//            System.out.println(indent);
//        }
    }

    @Test
    public void testDepartment(){
//        存
        Department department = new Department();
        department.setDepartmentName("市场运营部");
        departmentService.saveDepartment(department);
//        查全部
        List<Department> departments = departmentService.findAll();
        for (Department department1 : departments){
            System.out.println(department1);
        }
    }

    @Test
    public void testPosition(){
//        存（撤销）
//        Position position1 = new Position();
//        position1.setPositionName("产品经理");
//        positionService.savePosition(position1);
//        查全部
        List<Position> positions = positionService.findAll();
        for (Position position : positions){
            System.out.println(position);
        }
    }

    @Test
    public void testCategory(){
//        存
//        Category category1 = new Category();
//        category1.setCategoryName("洗衣机");
//        categoryService.saveCategory(category1);
//        查全部
//        List<Category> categories = categoryService.findAll();
//        for (Category category : categories){
//            System.out.println(category);
//        }
//        根据ID
        System.out.println(categoryService.findCategoryById(68425001));
    }

    @Test
    public void testProductCRUD(){
//        存
//        Product product = new Product();
//        Date date = new Date();
//        date.getTime();
//        product.setProductNum("nolva_v002");
//        product.setProductName("18寸无死角超高清彩电");
//        product.setCreateTime(date);
//        product.setProductPrice(7500);
//        product.setStock(6000);
//        product.setProductStatus(1);
//        product.setCategoryId(68425001);
//        productService.saveProduct(product);
//        System.out.println(product);
//        查全部
//        List<Product> products = productService.findAll();
//        for (Product product1 : products){
//            System.out.println(product1);
//            System.out.println(product1.getCreateTimeStr());
//        }
        Product product = productService.findProductById(6842531);
        System.out.println(product);
    }
}
