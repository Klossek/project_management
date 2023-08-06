
import { useEffect, useState } from 'react';
import axios from './api/axios';



import './App.css';
import Matrix from './components/Matrix';
import Error from './components/Error';
import Loading from './components/Loading';
import ProjectForm from './components/ProjectForm';
import EmployeeForm from './components/EmployeeForm';
import 'bootstrap/dist/css/bootstrap.min.css';
import { EmployeesProvider, useEmployees, useEmployeesDispatch } from './EmployeesContext';
function App() {

  const employees = useEmployees();
  const dispatch = useEmployeesDispatch();
  const [projects, setProjects] = useState();
  const [table, setTable] = useState([]);
  const [error, setError] = useState();
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadEmployees = async () => {
      const resEmployees = await axios.get("/employee");
      const employees = resEmployees.data;
      dispatch({
        type: 'loaded',
        employees,
      });
    };
    const loadProjects = async () => {
      const resProjects = await axios.get("/project");
      const projects = resProjects.data;
      setProjects(projects);
      return projects;
    };
    try {
      loadEmployees();
      loadProjects();
    } catch (error) {
      setError(error);
    }

  }, []);

  useEffect(() => {
    if (employees && projects) {
      const table = calcTable(employees, projects);
      setTable(table);
      setLoading(false);
    }
  }, [employees, projects]);

  const calcTable = (employees, projects) => {
    const table = [];
    let counter = 0;
    employees.map((employee) => {
      const row = [];
      projects.map(project => {

        const entry = {
          id: counter,
          employeeId: employee.id,
          employee,
          project,
          projectId: project.id,
          assigned: !!employee.projects.find((p) => p.id === project.id)
        };
        counter++;
        row.push(entry);
      });
      table.push(row);
    });
    return table;
  };

  const createProject = async (project) => {
    const res = await axios.post("/project", project);
    const databaseProject = res.data;
    setProjects([...projects, databaseProject]);
  };



  if (error) {
    return <Error error={error} />;
  }

  if (loading) {
    return <Loading />;
  }

  return (<>
    <Matrix table={table} projects={projects} employees={employees} />
    <div className='flex'>
      <ProjectForm onSubmit={createProject} />
      <EmployeeForm />
    </div>
  </>
  );
}


export default App;
