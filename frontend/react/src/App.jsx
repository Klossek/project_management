
import { useEffect, useState } from 'react';
import axios from './api/axios';


import './App.css';
import Matrix from './components/Matrix';
import Error from './components/Error';
import Loading from './components/Loading';

function App() {

  const [employees, setEmployees] = useState();
  const [projects, setProjects] = useState();
  const [error, setError] = useState();
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadEmployees = async () => {
      const resEmployees = await axios.get("/employee");
      setEmployees(resEmployees.data);
    };
    const loadProjects = async () => {
      const resProjects = await axios.get("/project");
      setProjects(resProjects.data);

    };
    try {
      const p1 = loadEmployees();
      const p2 = loadProjects();
      Promise.all([p1, p2]).then(() => {
        setLoading(false);
      });
    } catch (error) {
      setError(error);
    }

  }, []);


  if (error) {
    return <Error error={error} />;
  }

  if (loading) {
    return <Loading />;
  }

  return <>
    <Matrix projects={projects} employees={employees} />
  </>;



}

export default App;
