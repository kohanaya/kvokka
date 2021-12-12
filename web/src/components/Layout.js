import { Outlet } from 'react-router-dom'
import { React } from 'react'

export function Layout () {
  return (
    <>
      <h2>Project Management App</h2>
      <Outlet />
      <br /><br /><br /><br /><br />
      <hr />
      <div>Created by Hanna.</div>
    </>
  )
}
