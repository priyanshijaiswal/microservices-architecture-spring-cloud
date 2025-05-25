import axios from 'axios';

const EMPLOYEE_SERVICE_BASE_URL = "http://localhost:9191/api/employees";
const EMPLOYEE_ID = 5;

class EmployeeService {
    getEmployee() {
        const token = sessionStorage.getItem("accessToken");

        return axios.get(`${EMPLOYEE_SERVICE_BASE_URL}/${EMPLOYEE_ID}`, {
            headers: {
                Authorization: `Bearer ${token}`
            }
        });
    }
}

export default new EmployeeService();
