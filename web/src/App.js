import { React } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import { Container, createTheme, CssBaseline, ThemeProvider } from '@mui/material'
import SignIn from './pages/Login/LoginPage'
import SignUp from './pages/Register/RegistrePage'
import { Layout } from './components/Layout'
import { HomePage } from './pages/Home/HomePage'

const theme = createTheme()

function App () {
  return (
    <ThemeProvider theme={theme}>
      <Container component='main' maxWidth='lg'>
        <CssBaseline />
        <BrowserRouter>
          <Routes>
            <Route path='/' element={<Layout />}>
              <Route index element={<HomePage />} />
              {/*<Route path='projects'>*/}
              {/*  <Route path=':projectId' element={<ProjectDetails />} />*/}
              {/*  <Route path=':projectId/edit' element={<CourseEdit />} />*/}
              {/*  <Route path='new' element={<CourseEdit />} />*/}
              {/*  <Route index element={<Courses />} />*/}
              {/*</Route>*/}
            </Route>
            <Route path='/login' element={<SignIn />} />
            <Route path='/register' element={<SignUp />} />
          </Routes>
          <ToastContainer
            position='top-right'
            autoClose={2000}
            newestOnTop={false}
          />
        </BrowserRouter>
      </Container>
    </ThemeProvider>
  )
}

export default App
