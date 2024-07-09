/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap <Integer, Imp> hashMap;
    int impo;

    class Imp {
        public int importance;
        public List<Integer> subordinates;

        public Imp(int importance, List<Integer> subordinates){
            this.importance = importance;
            this.subordinates = new ArrayList<Integer>();
            this.subordinates = subordinates;
        }
    }

    public void getTotal(int empId){
        Imp imp = this.hashMap.get(empId);
        impo = impo + imp.importance;
        List<Integer> list = imp.subordinates;
        for(Integer id : list){
            getTotal(id);
        }
    }

    public int getImportance(List<Employee> employees, int id) {
        this.hashMap = new HashMap<Integer, Imp>();

        this.impo = 0;

        for(Employee e : employees){
            hashMap.put(e.id, new Imp(e.importance, e.subordinates));
        }

        getTotal(id);

        return impo;
    }
}
