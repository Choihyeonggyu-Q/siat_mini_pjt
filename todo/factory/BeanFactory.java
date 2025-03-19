package todo.factory;

import java.util.HashMap;
import java.util.Map;

import todo.ctrl.TodoCheckController;
import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoReadController;
import todo.ctrl.TodoSelectController;
import todo.ctrl.TodoSortController;
import todo.ctrl.TodoUncheckController;
import todo.ctrl.TodoUpdateController;
import todo.service.TodoService;

public class BeanFactory {
    public Map<String, Object> map;
    private static BeanFactory instance;
    private BeanFactory(){
        map = new HashMap<>();
        TodoService service = new TodoService();
        map.put("list", new TodoSelectController(service));
        map.put("register", new TodoInsertController(service));
        map.put("update", new TodoUpdateController(service));
        map.put("delete", new TodoDeleteController(service));
        map.put("read", new TodoReadController(service));
        map.put("check", new TodoCheckController(service));
        map.put("uncheck", new TodoUncheckController(service));
        map.put("sort", new TodoSortController(service));
    }

    public static BeanFactory getInstance(){
        if(instance == null){
            instance = new BeanFactory();
        }
        return instance;
    }

    public Object getCtrl(String key){
        return map.get(key);
    }
}
