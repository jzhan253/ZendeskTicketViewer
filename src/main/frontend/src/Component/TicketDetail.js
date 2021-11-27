import React, {useEffect, useState} from "react";
import {Link, useNavigate, useParams} from "react-router-dom";
import {Button, Layout, PageHeader, Tag} from "antd";
import {getTicket} from "../utils";
import {format} from "date-fns";

function TicketDetail() {
    const [item, setItem] = useState([]);
    const [tags, setTags] = useState([]);
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const navigate = useNavigate();
    const { id } = useParams();
    useEffect( () => {
        getTicket(id)
            .then(res => res)
            .then(
                (result) => {
                    if (result.resultCode === 200) {
                        setItem(result.data);
                        setIsLoaded(true);
                        setTags(result.data.tags);
                    } else {
                        setError(result.message);
                        setIsLoaded(true);
                    }
                }, (error) => {
                    setIsLoaded(true)
                    setError(error.message)
                }
            )
    });
    if(error){
        return (
            <div>
                <text>Error : {error}</text>
                <Link to='/tickets'><Button>Back to ticket list</Button></Link>
            </div>
        );
    } else if(!isLoaded){
        return (
            <Layout style={{textAlign: 'center'}}>Loading...</Layout>
        );
    } else {
        return (
            <Layout>
                <PageHeader
                    onBack = {()=>{
                        navigate('/tickets');
                    }}
                    title=  { 'Subject: ' + item.subject}
                    subTitle={format(new Date(item.created_at), "yyyy-MM-dd HH:mm")}
                />
                <container style={{width:'65%', marginLeft:'3%'}}>
                    <div>
                        <text><strong>Requester ID</strong>: {item.requester_id}</text>
                        <hr/>
                        <Tag color={item.status === 'open' ? 'red' : 'green'}>{item.status}</Tag>
                        <text>Ticket #{item.id}</text>
                    </div>
                    <hr/><p><strong>Description</strong>:<br /> {item.description}</p>
                    <div> <strong>tags</strong>:
                        {
                            tags.map( res =>{
                                let color = res.length > 5 ? 'purple' : 'pink';
                                return (
                                    <Tag color={color} key={res}>
                                        {res}
                                    </Tag>
                                )}
                            )}
                    </div>
                </container>
            </Layout>
        ) ;
    }
}

export default TicketDetail;