import React, { useEffect, useState } from 'react'
import CustomerDataService from '../services/customer.service'
import Table from '@mui/material/Table'
import TableBody from '@mui/material/TableBody'
import TableCell from '@mui/material/TableCell'
import TableContainer from '@mui/material/TableContainer'
import TableHead from '@mui/material/TableHead'
import TableRow from '@mui/material/TableRow'
import Paper from '@mui/material/Paper'
import Box from '@mui/material/Box'
import TextField from '@mui/material/TextField'
import Button from '@mui/material/Button'

const CustomerList = () => {
    const [customers, setCustomers] = useState(null)
    const [country, setCountry] = useState("")
    const [phoneState, setPhoneState] = useState("")

    const fetchCustomers = () => {
        CustomerDataService
            .getAllCustomers()
            .then(response => {
                console.log(response)
                if (response.data.code === '200') {
                    setCustomers(response.data.data)
                } else {

                }
            })
            .catch(e => {
                console.log(e)
            })
    }

    const filterCustomers = (c, p) => {
        CustomerDataService
            .getFilteredCustomers(c, p)
            .then(response => {
                console.log(response)
                if (response.data.code === '200') {
                    setCustomers(response.data.data)
                } else {

                }
            })
            .catch(e => {
                console.log(e)
            })
    }

    useEffect(() => {
        fetchCustomers()
    }, [])

    return <>
            <div className="Filter-section">
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 1, width: '25ch' },
                    }}
                    noValidate
                    autoComplete="off"
                    >
                    <TextField 
                        label="Country" 
                        color="secondary" 
                        onChange={(e) => {
                            setCountry(e.target.value)
                        }}
                    />
                    <TextField 
                        label="State" 
                        color="secondary" 
                        onChange={(e) => {
                            setPhoneState(e.target.value)
                        }}
                    />
                    <Button 
                        variant="contained"
                        onClick={() => {
                            filterCustomers(country, phoneState)
                        }}
                    >
                        Filter
                    </Button>
                </Box>
            </div>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Name</TableCell>
                            <TableCell align="right">Country</TableCell>
                            <TableCell align="right">Phone Number</TableCell>
                            <TableCell align="right">State</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {customers && customers.map((row) => (
                            <TableRow
                                key={row.name}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell component="th" scope="row">
                                    {row.name}
                                </TableCell>
                                <TableCell align="right">{row.country}</TableCell>
                                <TableCell align="right">{row.phoneNumber}</TableCell>
                                <TableCell align="right">{row.isPhoneValid}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </>;
};

export default CustomerList;
